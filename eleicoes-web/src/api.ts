import axios from "axios";
import { ConfirmarVoto } from "./Voto/types";

const API_URL = 'http://localhost:8080';

export function fecthCandidatos(){
    return axios(`${API_URL}/candidatos`)
}

export function saveVotos(voto: ConfirmarVoto){
    return axios.post(`${API_URL}/votos`,voto);
}

//export function fecthLogin(nomeUsuario:string){
//    return axios(`${API_URL}/usuario/email/${nomeUsuario}`)
//}

export function fecthLogin(){
    return axios(`${API_URL}/usuario/email/abrito10@gmail.com`)
}



