export type CandidatoVoto = {
    id: number;
    nomeCandidato: string;
    imagemCandidato: string;
    cargo: string;
}

type CandidatoID = {
    id:number;
}

export type ConfirmarVoto = {
    candidatoVoto: CandidatoID[];
}
