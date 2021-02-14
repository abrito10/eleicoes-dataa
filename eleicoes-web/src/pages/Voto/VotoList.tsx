import { checkIsSelected } from "./helpers";
import { CandidatoVoto } from "./types";
import VotoCard from "./VotoCard";

type Props = {
    candidatos: CandidatoVoto[];
    selectedCandidatos: CandidatoVoto[];
    onSelectCandidato: (candidato: CandidatoVoto) => void;

}

function VotoList({ candidatos, selectedCandidatos, onSelectCandidato }: Props){
    return (

        <div className = "voto-list-container ">
            <div className = "voto-list-items">
                {candidatos.map(candidato => (
                    <VotoCard 
                    key=
                    {candidato.id} 
                    candidato={candidato}
                    onSelectCandidato={onSelectCandidato}
                    isSelected={checkIsSelected(selectedCandidatos,candidato)}/>
                ))}
            </div>
        </div>

    )
}

export default VotoList;