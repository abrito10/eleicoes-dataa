import './style.css';
import { useAuth } from '../../contexts/auth';


const Eleicao: React.FC = () => {
    const { signed } = useAuth();
    console.log(signed);

    return (
        <>
            <div className="cargo-container">
                <div className="cargo-content">
                    <div>Eleicao</div>
                </div>
            </div>
        </>

    )
}

export default Eleicao;