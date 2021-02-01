import { Candidato } from "./types";

export function checkIsSelected(selectedCandidatos: Candidato[], candidato: Candidato){
    return selectedCandidatos.some(item => item.id === candidato.id);
}

export function formatPrice(price : number){
    const formatter = new Intl.NumberFormat('pt-BR',{
        style: 'currency',
        currency: 'BRL',
        minimumFractionDigits: 2

    });
    return formatter.format(price)
}