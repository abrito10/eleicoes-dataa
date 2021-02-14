import * as React from "react";
import { Usuarios } from './types';
import { render } from "react-dom";
import { Formik, Form, Field, ErrorMessage, FormikHelpers as FormikActions, withFormik } from 'formik';
import * as Yup from 'yup';
import { saveUsuario } from "../../services/api";
import { toast } from 'react-toastify';
import './style.css';

const enhanceWithFormik = withFormik({
  mapPropsToValues: () => ({ nomeUsuario: '', cpf: '', email: '', senha: '' }),
  handleSubmit: values => {
    console.log(values)
  },
  isInitialValid: false,
  validateOnChange: true,
  validateOnBlur: true,
  displayName: 'Usuario'
})

const Usuario: React.FC = () => (
  <div className="container">
    <h1>Cadastro de Usuario</h1>
    <Formik
      initialValues={{
        nomeUsuario: "",
        cpf: "",
        email: "",
        senha: ""
      }}

      validationSchema={Yup.object().shape({
        nomeUsuario: Yup.string().required(' Nome obrigatório'),
        cpf: Yup.string().required(' CPF obrigatório'),
        email: Yup.string().required(' Email obrigatório'),
        senha: Yup.string().required(' Senha obrigatório')
      })}

      onSubmit={(usuarios: Usuarios, { setStatus, setSubmitting }: FormikActions<Usuarios>) => {
        setStatus();
        saveUsuario(usuarios)
          .then((response) => {
            toast.info(`Usuario salvo = ${response.data.nomeUsuario}`, {
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
            toast.warning('Erro ao salvar o novo usuario');
          })
        setSubmitting(false);

        //setTimeout(() => {
        //  alert(JSON.stringify(usuarios, null, 2));
        //  setSubmitting(false);
        //}, 500);
      }}


      render={() => (
        <Form>
          <div className="form-group">
            <label htmlFor="nomeUsuario">Nome do Usuario</label>
            <Field id="nomeUsuario" name="nomeUsuario" placeholder="Entre com o nome " type="text" />
            <ErrorMessage name="nomeUsuario" />
          </div>

          <div className="form-group">
            <label htmlFor="cpf">CPF</label>
            <Field id="cpf" name="cpf" placeholder="Selecione o CPF" type="text" />
            <ErrorMessage name="cpf" />
          </div>

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
            <button className="usuario-btn-salvar" type="submit" style={{ display: "block" }}>
              Salvar
          </button>
          </div>
        </Form>
      )}
    />
  </div>
);

render(<Usuario />, document.getElementById("root"));

export default enhanceWithFormik(Usuario)