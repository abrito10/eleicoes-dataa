
import { Candidato } from "./types";

type Props = {
    candidato: Candidato
    onSelectCandidato: (candidato: Candidato) => void;
    isSelected: boolean;
}

function VotoCard({ candidato, onSelectCandidato, isSelected}: Props){
    return (
        <div 
        className = {`voto-card-container ${isSelected ? 'selected' : ''}` }
        onClick={() => onSelectCandidato(candidato)}
        >
            <h3 className = "voto-card-title">
             {candidato.nomeCandidato}
            </h3>
            <img 
                src={candidato.imagemCandidato} 
                className="voto-card-image"
                alt={candidato.nomeCandidato}/>
            <h3 className = "voto-card-numero-candidato">
              {candidato.id}
            </h3>
            <div className = "voto-card-description">
              {candidato.cargo}
            </div>
        </div>

    )
}

export default VotoCard;