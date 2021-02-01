import { BrowserRouter, Switch, Route } from "react-router-dom";
import Home from "./Home";
import Navbar from "./Navbar";
import Eleicao from "./Eleicao";
import Usuario from "./Usuario";
import Candidato from "./Candidato";
import Voto from "./Voto";
import Cargo from "./Cargo";
import Login from "./Login";


function Routes(){

    return(
        <BrowserRouter >
            <Navbar />
            <Switch>

                <Route  path = "/login" > 
                    <Login />
                </Route>

                <Route path = "/usuarios"> 
                    <Usuario />
                </Route>

                <Route path = "/votos"> 
                    <Voto />
                </Route>

                <Route path = "/cargos"> 
                    <Cargo />
                </Route>

                <Route path = "/eleicoes"> 
                    <Eleicao />
                </Route>

                <Route path = "/candidatos"> 
                    <Candidato />
                </Route>
                
                <Route path = "/home">
                    <Home />
                </Route>


            </Switch>
        </BrowserRouter>
    )
}
export default Routes;