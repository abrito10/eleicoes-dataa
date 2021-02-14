import { useEffect, useState } from 'react';
import { toast } from 'react-toastify';

import { fecthCandidatos, saveVotos } from "../../services/api";

import Footer from '../Footer';
import ConfirmarVoto from './confirmarVoto';
import { checkIsSelected } from './helpers';
import PassosVotacao from './PassosVotacao';
import { CandidatoVoto } from './types';
import VotoList from './VotoList';
import './style.css';
import { useAuth } from '../../contexts/auth';

const Voto: React.FC = () => {
  const { signed } = useAuth();
  console.log(signed);

 // function Voto(){
    const [candidados, setCandidatos] = useState<CandidatoVoto[]>([]);
    const [selectedCandidados, setSelectedCandidatos] = useState<CandidatoVoto[]>([]);
    const totalVotos= selectedCandidados.reduce((sum, item) => {
        return sum + 1;
    },0);
    
    useEffect(() => {
        fecthCandidatos()
        .then(response => setCandidatos(response.data))
        .catch(error => console.log(error))
    },[]);

    const handleSelectCandidato = (candidato: CandidatoVoto) => {
        const isAlreadySelected = checkIsSelected(selectedCandidados,candidato);
      
        if (isAlreadySelected) {
            const selected = selectedCandidados.filter(item => item.id !== candidato.id);
            setSelectedCandidatos(selected);
        } else {
          setSelectedCandidatos(previous => [...previous, candidato]);
        }
      }

      const handleSubmit = () => {
        const candidatosIds = selectedCandidados.map(({ id }) => ({ id }));
        const voto = {
          candidatoVoto: candidatosIds
        }
      
        saveVotos(voto)
        .then((response) => {
          toast.info(`Protocolo:  ${response.data.protocolo}`,{
            position: "top-center",
            autoClose: false,
            hideProgressBar: false,
            closeOnClick: true,
            pauseOnHover: false,
            draggable: true,
            progress: undefined,
          }
          );
          setSelectedCandidatos([]);
        })
          .catch(() => {
            toast.warning('Erro ao confirmar voto');
          })
      }
     
    return (
        <> 
            <div> 
            <PassosVotacao/>
            <VotoList 
            candidatos={candidados}
            onSelectCandidato={handleSelectCandidato}
            selectedCandidatos={selectedCandidados}/>

            <ConfirmarVoto 
                amount={selectedCandidados.length} 
                totalVotos={totalVotos}  
                onSubmit={handleSubmit}/>
            </div>
            <Footer/>
        </> 
    )
}

export default Voto;