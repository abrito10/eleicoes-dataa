import './style.css';
import { useAuth } from '../../contexts/auth';

const Cargo: React.FC = () => {
    const { signed } = useAuth();
    console.log(signed);

    return (
        <>
            <div className="cargo-container">
                <div className="cargo-content">
                    <div>cargo</div>
                </div>
            </div>
        </>
    )
}

export default Cargo;