import axios from "axios";
import { ConfirmarVoto } from "../pages/Voto/types"

//const API_URL = 'http://localhost:8080';
const API_URL = process.env.REACT_APP_API_URL;

export function fecthCandidatos(){
    return axios(`${API_URL}/candidatos`)
}

export function saveVotos(voto: ConfirmarVoto){
    return axios.post(`${API_URL}/votos`,voto);
}

export function fecthLogin(){
    return axios(`${API_URL}/usuario/email/abrito10@gmail.com`)
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

// buscar usuario
//export function fecthLogin(nomeUsuario:string){
//    return axios(`${API_URL}/usuario/email/${nomeUsuario}`)
//}


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

