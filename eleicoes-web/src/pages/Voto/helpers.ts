import { CandidatoVoto } from "./types";

export function checkIsSelected(selectedCandidatos: CandidatoVoto[], candidato: CandidatoVoto){
    return selectedCandidatos.some(item => item.id === candidato.id);
}
