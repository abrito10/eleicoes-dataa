export type Candidatos = {
    nomeCandidato: string;
    imagemCandidato: string;
    cargo: string;
  }

  export type CargoCandidato = {
    id: number;
    nomeCargo: string;
}

type CargoId = {
  id:number;
}

export type ConfirmarCandidato = {
  cargoCandidato: CargoId[];
}
