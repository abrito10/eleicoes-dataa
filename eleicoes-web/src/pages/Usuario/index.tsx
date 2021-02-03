import './style.css';
import { useAuth } from '../../contexts/auth';

const Usuario: React.FC = () => {
    const { signed } = useAuth(); 
    
    console.log(signed);

    return (
        <>
        <div className="cargo-container">
            <div className="cargo-content">
                <div>Usuario</div>
            </div>
        </div>
    </>
    )
}

export default Usuario;