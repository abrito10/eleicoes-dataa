import { useEffect, useState } from 'react';
import { toast } from 'react-toastify';

import { fecthCandidatos, saveVotos } from '../api';
import Footer from '../Footer';
import ConfirmarVoto from './confirmarVoto';
import { checkIsSelected } from './helpers';
import PassosVotacao from './PassosVotacao';
import { Candidato } from './types';
import VotoList from './VotoList';
import './style.css';

function Voto(){

    const [candidados, setCandidatos] = useState<Candidato[]>([]);
    const [selectedCandidados, setSelectedCandidatos] = useState<Candidato[]>([]);
    const totalVotos= selectedCandidados.reduce((sum, item) => {
        return sum + 1;
    },0);
    useEffect(() => {
        fecthCandidatos()
        .then(response => setCandidatos(response.data))
        .catch(error => console.log(error))
    },[]);

    const handleSelectCandidato = (candidato: Candidato) => {
        const isAlreadySelected = checkIsSelected(selectedCandidados,candidato);
        //const isAlreadySelected = selectedCandidados.some(item => item.id === candidato.id);
      
        if (isAlreadySelected) {
            //const selected = selectedCandidatos.filter(item => item.id !== candidato.id);
            const selected = selectedCandidados.filter(item => item.id !== candidato.id);
            setSelectedCandidatos(selected);
        } else {
          setSelectedCandidatos(previous => [...previous, candidato]);
        }
      }

      const handleSubmit = () => {
        const candidatosIds = selectedCandidados.map(({ id }) => ({ id }));
        const voto = {
          candidatos: candidatosIds
        }
      

        saveVotos(voto)
        .then((response) => {
          toast.error(`Protocolo ${response.data.protocolo}`);
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