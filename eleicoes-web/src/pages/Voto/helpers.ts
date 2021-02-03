import { Candidato } from "./types";

export function checkIsSelected(selectedCandidatos: Candidato[], candidato: Candidato){
    return selectedCandidatos.some(item => item.id === candidato.id);
}
