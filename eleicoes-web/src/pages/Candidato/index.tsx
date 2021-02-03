import './style.css';
import { useAuth } from '../../contexts/auth';


const Candidato: React.FC = () => {
    const { signed } = useAuth();
    console.log(signed);

    return (
        <>
            <div className="candidato-container">
                <div className="candidato-content">
                    <div>candidato</div>
                </div>
            </div>
        </>
    )
}

export default Candidato;