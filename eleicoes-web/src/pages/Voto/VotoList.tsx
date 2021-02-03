import { checkIsSelected } from "./helpers";
import { Candidato } from "./types";
import VotoCard from "./VotoCard";

type Props = {
    candidatos: Candidato[];
    selectedCandidatos: Candidato[];
    onSelectCandidato: (candidato: Candidato) => void;

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