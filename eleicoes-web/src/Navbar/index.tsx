import './style.css';
import { Link } from "react-router-dom";
function Navbar(){
    return (

        <nav className="main-navbar">
            <Link to="/home" className= "logo-text">Eleicao - Data A</Link>
        </nav>

    )
}
 
export default Navbar;