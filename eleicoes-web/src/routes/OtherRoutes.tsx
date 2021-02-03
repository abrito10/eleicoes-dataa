import React from 'react';
import { BrowserRouter, Switch ,Route } from 'react-router-dom';
import Candidato from '../pages/Candidato';
import Cargo from '../pages/Cargo';
import Eleicao from '../pages/Eleicao';

import Home from '../pages/Home';
import Usuario from '../pages/Usuario';
import Voto from '../pages/Voto';

const OtherRoutes: React.FC = () => {
 return (
   <BrowserRouter>
    <Switch>
      <Route exact path="/" component={Home} />

      <Route exact path="/eleicoes" component={Eleicao} />

      <Route exact path="/candidatos" component={Candidato} />

      <Route exact path="/cargos" component={Cargo} />

      <Route exact path="/usuarios" component={Usuario} />

      <Route exact path="/votos" component={Voto} />




    </Switch>
   </BrowserRouter>
 );
};


export default OtherRoutes;