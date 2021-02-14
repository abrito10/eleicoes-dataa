import React from 'react';
import { Formik, Field, Form } from 'formik';


const Teste = () => (
  <div>
    <h1>Checkboxes</h1>
    <Formik
      initialValues={{
        location: '',
      }}
      onSubmit={async values => {
        alert(JSON.stringify(values, null, 2));
      }}
    >
      {({ isSubmitting, values }) => (
        <Form>
          
          <label htmlFor="location">Selecione</label>
          
          <Field
            component="select"
            id="location"
            name="location"
            multiple={false}
          >
            <option value="NY">New York</option>
            <option value="SF">San Francisco</option>
            <option value="CH">Chicago</option>
            <option value="OTHER">Other</option>
          </Field>
     
     
          <button type="submit" disabled={isSubmitting}>
            Submit
          </button>
        </Form>
      )}
    </Formik>
  </div>
);

export default Teste;