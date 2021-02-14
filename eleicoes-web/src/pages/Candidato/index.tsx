import * as React from "react";
import { render } from "react-dom";

import { Formik, Form, Field, ErrorMessage, FormikHelpers as FormikActions, withFormik } from 'formik';
import * as Yup from 'yup';
import { saveCandidato } from "../../services/api";

import { Candidatos } from './types';
import { toast } from 'react-toastify';

import './style.css';

const enhanceWithFormik = withFormik({
  mapPropsToValues: () => ({ nomeCandidato: '', imagemCandidato: '',cargo:''}),
  handleSubmit: values => {
    console.log(values)
  },
  isInitialValid: false,
  validateOnChange: true,
  validateOnBlur: true,
  displayName: 'Candidato'
})

const Candidato: React.FC = () => (

  <div className="container">
    <h1>Cadastro de Candidato</h1>
    <Formik
      initialValues={{
        nomeCandidato: "",
        imagemCandidato: "",
        cargo:""
      }}

      validationSchema={Yup.object().shape({
        nomeCandidato: Yup.string().required(' Nome obrigatório'),
        imagemCandidato: Yup.string().required(' Imagem obrigatório'),
        cargo: Yup.string().required(' Cargo obrigatório')
      })}

      onSubmit={(candidatos: Candidatos, { setStatus, setSubmitting }: FormikActions<Candidatos>) => {
        setStatus();
        saveCandidato(candidatos)
          .then((response) => {
            toast.info(`Candidato salvo = ${response.data.nomeCandidato}`, {
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
            toast.warning('Erro ao salvar o novo candidato');
          })
        setSubmitting(false);

        setTimeout(() => {
          alert(JSON.stringify(candidatos, null, 2));
          setSubmitting(false);
        }, 500);
      }}
      render={() => (
        <Form>

          <div className="form-group">
            <label htmlFor="nomeCandidato">Nome do Candidato</label>
            <Field id="nomeCandidato" name="nomeCandidato" placeholder="Entre com o nome " type="text" />
            <ErrorMessage name="nomeCandidato" />
          </div>

          <div className="form-group">
            <label htmlFor="imagemCandidato">Image...</label>
            <Field id="imagemCandidato" name="imagemCandidato" placeholder="Selecione a imagem" type="text" />
            <ErrorMessage name="imagemCandidato" />
          </div>


          <div className="form-group">
          <label htmlFor="cargo">Cargo</label>
          
          <Field component="select" id="cargo" name="cargo" type="text" multiple={false} placeholder="Entre com o cargo">
          <option value="">Selecione um Cargo</option>
          <option value="1">New York</option>
            <option value="2">San Francisco</option>
            <option value="3">Chicago</option>
            <option value="4">Other</option>
          </Field>
          <ErrorMessage name="cargo" />

          </div>

          <div>

          </div>
          <button className="candidato-btn-salvar" type="submit" style={{ display: "block" }}>
            Salvar
          </button>
        </Form>
      )}
    />
  </div>
);

render(<Candidato />, document.getElementById("root"));

export default enhanceWithFormik(Candidato)