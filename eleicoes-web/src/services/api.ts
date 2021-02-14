import axios from "axios";
import { Cargos } from "../pages/Cargo/types";
import { Usuarios } from "../pages/Usuario/types";
import { ConfirmarVoto } from "../pages/Voto/types";
import { Candidatos } from "../pages/Candidato/types";
import { Eleicoes } from "../pages/Eleicao/types";
import { CredenciaisDTO } from "../pages/Login/types"

//const API_URL = 'http://localhost:8080';
const API_URL = process.env.REACT_APP_API_URL;

export function fecthCandidatos(){
    return axios(`${API_URL}/candidatos`)
}

export function saveVotos(voto: ConfirmarVoto){
    return axios.post(`${API_URL}/votos`,voto);
}

export function saveCargo(cargo: Cargos){
  return axios.post(`${API_URL}/cargos`,cargo);
}

export function saveUsuario(usuario: Usuarios){
  return axios.post(`${API_URL}/usuarios`,usuario);
}

export function saveCandidato(candidato: Candidatos){
  return axios.post(`${API_URL}/candidatos`,candidato);
}

export function fecthCargo(){
  return axios(`${API_URL}/cargos`)
}

export function saveEleicao(eleicoes: Eleicoes){
  return axios.post(`${API_URL}/eleicoes`,eleicoes);
}

export function toLogin(login:CredenciaisDTO){
    return axios.post(`${API_URL}/login`,login);
}

interface Response {
  data: {
    user: {
      name: string;
      email: string;
      root: string;
    };
    token: string;
  };
}


export function post(text: string, user: object): Promise<Response> {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve({
        data: {
          token:
            '91j893h281h9nf98fnf2309jd09jkkd0as98238j9fr8j98f9j8f298r829r-f',
          user: {
            name: 'Adilson',
            email: 'abrito10@gmail.com',
            root:'ADMIN'
          },
        },
      });
    }, 2000);
  });
}

export const defaults = {
  headers: {
    Authorization: '',
  },
};

