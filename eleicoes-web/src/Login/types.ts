export type UsuarioLogin = {
    id: number;
    nomeUsuario: string;
    cpf: string;
    email: string;
    senha: string;
}


export type State = {
    username: string
    password:  string
    isButtonDisabled: boolean
    helperText: string
    isError: boolean
    redirect:boolean
  };
  
  export const initialState:State = {
    username: '',
    password: '',
    isButtonDisabled: true,
    helperText: '',
    isError: false,
    redirect: false   
  
  };

  export type Action = { type: 'setUsername', payload: string }
  | { type: 'setPassword', payload: string }
  | { type: 'setIsButtonDisabled', payload: boolean }
  | { type: 'loginSuccess', payload: string }
  | { type: 'loginFailed', payload: string }
  | { type: 'setIsError', payload: boolean };