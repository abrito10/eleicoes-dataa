//import { useAuth } from '../../contexts/auth';
import * as React from "react";
import { render } from "react-dom";
import { Cargos } from './types';

import { Formik, Form, Field, ErrorMessage, FormikHelpers as FormikActions, withFormik } from 'formik';
import * as Yup from 'yup';
import './style.css';
import { saveCargo } from "../../services/api";
import { toast } from 'react-toastify';

const enhanceWithFormik = withFormik({
  mapPropsToValues: () => ({ nomeCargo: '' }),
  handleSubmit: salvarCargo => {
  },
  isInitialValid: false,
  validateOnChange: true,
  validateOnBlur: true,
  displayName: 'Cargo'
})

const Cargo: React.FC = () => (

  <div className="container">
    <h1>Cadastro de Cargo</h1>
    <Formik
      initialValues={{
        nomeCargo: ""
      }}

      validationSchema={Yup.object().shape({
        nomeCargo: Yup.string().required(' Nome obrigatório')
      })}

      onSubmit={(cargos: Cargos, { setSubmitting }: FormikActions<Cargos>) => {
        saveCargo(cargos)
          .then((response) => {
            toast.info(`Cargo salvo = ${response.data.nomeCargo}`, {
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
            toast.warning('Erro ao salver o novo cargo');
          })
        setSubmitting(false);

        // para testar com um alert na tela 
        //setTimeout(() => {
        //  alert(JSON.stringify(cargos, null, 2));
        //  setSubmitting(false);
        //}, 500);
      }}

      render={() => (
        <Form>

          <div className="form-group">
            <label htmlFor="nomeCargo">Nome do Cargo</label>
            <Field id="nomeCargo" name="nomeCargo" placeholder="Entre com o nome " type="text" />
            <ErrorMessage name="nomeCargo" />
          </div>

          <button className="cargo-btn-salvar" type="submit" style={{ display: "block" }} >
            Salvar
          </button>
        </Form>
      )}
    />
  </div>
);

render(<Cargo />, document.getElementById("root"));

export default enhanceWithFormik(Cargo)