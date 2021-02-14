//import React from 'react';
//import { useAuth } from '../../contexts/auth';
//import { Formik, Field, Form, ErrorMessage } from 'formik';
//import * as Yup from 'yup';
//import './style.css';
//import { authenticationService } from '../../_services';

//const Login: React.FC = () => {
//  const { signed, Login } = useAuth();

//  console.log(signed);

//  async function handleLogin() {
//    await Login({
//    email: 'abrito10@gmail.com',
//      password: '123456',
//    });
//    }

//  return (
//    <>
//      <div className="login-container">
//        <div className="login-content">
//          <div>
//            <h1>teste</h1>
//            <button className="login-summary-make-login" onClick={handleLogin}>Login</button>
//          </div>
//        </div>
//      </div>
//    </>
//  );
//};

//export default Login;

import {  CredenciaisDTO } from './types';
import { render } from "react-dom";
import { Formik, Form, Field, ErrorMessage, FormikHelpers as FormikActions, withFormik } from 'formik';
import * as Yup from 'yup';
import './style.css';
import { toast } from 'react-toastify';
import { toLogin } from "../../services/api";

const enhanceWithFormik = withFormik({
  mapPropsToValues: () => ({ email: '', senha: '' }),
  handleSubmit: values => {
    console.log(values)
  },
  isInitialValid: false,
  validateOnChange: true,
  validateOnBlur: true,
  displayName: 'Login'})

const Login: React.FC = () => (
 
 <div className="container">
    <h1>Login</h1>
    <Formik
      initialValues={{
        email: "",
        senha:""
      }}

      validationSchema={Yup.object().shape({
        email: Yup.string().required(' Email obrigatório'),
        senha: Yup.string().required(' Senha obrigatório')
    })}

      onSubmit={async(entrar: CredenciaisDTO, { setStatus, setSubmitting }: FormikActions<CredenciaisDTO>) => {
        setStatus();
        toLogin(entrar)
        .then((response) => {
          toast.info(`logado = ${response.data}`, {
            position: "top-center",
            autoClose: 5000,
            hideProgressBar: false,
            closeOnClick: true,
            pauseOnHover: true,
            draggable: true,
            progress: undefined,
          });
        })
        .catch(() => {
          toast.warning('Usuario ou Senha errados ');
        })
      setSubmitting(false);              
        setTimeout(() => {
          alert(JSON.stringify(entrar, null, 2));
          setSubmitting(false);
        }, 500);
      }}


      render={() => (
        <Form> 
          <div className="form-group">
          <label htmlFor="email">Email</label>
          <Field id="email" name="email" placeholder="Entre com o email" type="text" />
          <ErrorMessage name="email" />
          </div>

          <div className="form-group">
          <label htmlFor="senha">Senha</label>
          <Field id="senha" name="senha" placeholder="Entre com a senha" type="password" />
          <ErrorMessage name="senha" />
          </div>

          <div className="form-group">
          <button className="btn-login" type="submit" style={{ display: "block" }}>Login</button>
         </div>
        </Form>
      )}
    />
  </div> 
);

render(<Login />, document.getElementById("root"));

export default enhanceWithFormik (Login)