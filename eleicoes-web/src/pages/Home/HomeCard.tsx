import './style.css';
import { Link } from "react-router-dom";

function HomeCard() {
    return (
        <>
            <div className=".login-content">
                <div className="main-home">
                    <Link to="/eleicoes" className="home-card-title">Eleições</Link>
                </div>

                <div className="main-home">
                    <Link to="/candidatos" className="home-card-title">Candidatos</Link>
                </div>

                <div className="main-home">
                    <Link to="/cargos" className="home-card-title">Cargos</Link>
                </div>

                <div className="main-home">
                    <Link to="/usuarios" className="home-card-title">Usuarios</Link>
                </div>

                <div className="main-home">
                    <Link to="/votos" className="home-card-title">Votos</Link>
                </div>
            </div>

        </>
                //<div className="main-home">
                //    <Link to="/teste" className="home-card-title">Teste</Link>
                //</div>
    )
}

export default HomeCard;