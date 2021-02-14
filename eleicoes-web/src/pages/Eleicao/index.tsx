import './style.css';
//import { useAuth } from '../../contexts/auth';
import * as React from "react";
import { render } from "react-dom";
import { Eleicoes } from './types';
import { Formik, Form, Field, ErrorMessage, FormikHelpers as FormikActions, withFormik } from 'formik';
import * as Yup from 'yup';
import { toast } from 'react-toastify';

import './style.css';
import { saveEleicao } from '../../services/api';

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

const Eleicao: React.FC = () => (

  <div className="container">
    <h1>Cadastro de Eleicao</h1>
    <Formik
      initialValues={{
        nomeEleicao: "",
        dataInicio: "",
        dataTermino: ""
      }}
      validationSchema={Yup.object().shape({
        nomeEleicao: Yup.string().required(' Nome obrigatório'),
        dataInicio: Yup.string().required(' Data Inicio obrigatório'),
        dataTermino: Yup.string().required(' Data Termino obrigatório')
      })}


      onSubmit={(eleicoes: Eleicoes, { setStatus, setSubmitting }: FormikActions<Eleicoes>) => {
        setStatus();
        saveEleicao(eleicoes)
          .then((response) => {
            toast.info(`Eleição salva = ${response.data.nomeEleicao}`, {
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
            toast.warning('Erro ao salvar o nova eleição');
          })
        setSubmitting(false);    
          
        //   setTimeout(() => {
        //     alert(JSON.stringify(eleicoes, null, 2));
        //     setSubmitting(false);
        //   }, 500);
      }}
      render={() => (
        <Form>
          <div className="form-group">
            <label htmlFor="nomeEleicao">Nome da Eleicao</label>
            <Field id="nomeEleicao" name="nomeEleicao" placeholder="Entre com o nome " type="text" />
            <ErrorMessage name="nomeEleicao" />
          </div>

          <div className="form-group">
            <label htmlFor="dataInicio">Data de Inicio</label>
            <Field id="dataInicio" name="dataInicio" placeholder="Data de Inicio" type="date" />
            <ErrorMessage name="dataInicio" />
          </div>

          <div className="form-group">
            <label htmlFor="dataTermino">Data de Termino</label>
            <Field id="dataTermino" name="dataTermino" placeholder="Data de Termino" type="date" />
            <ErrorMessage name="dataTermino" />
          </div>

          <button className="candidato-btn-salvar" type="submit" style={{ display: "block" }}>
            Salvar
          </button>
        </Form>
      )}
    />
  </div>
);

render(<Eleicao />, document.getElementById("root"));

export default enhanceWithFormik(Eleicao)