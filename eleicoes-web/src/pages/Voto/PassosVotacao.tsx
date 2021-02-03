function PassosVotacao(){
    return (

        <header className = "voto-steps-container">
            <div className = "voto-steps-content">
                <h1 className = "steps-title">
                    Eleicao
                </h1>
                <ul className = "steps-items">
                    <li>
                    <span className = "steps-number">1</span>
                        Selecione os Candidatos 
                    </li>
                    <li>
                    <span className = "steps-number">2</span>
                        Depois clique em <strong>"VOTAR"</strong> para confirmar seu voto
                    </li>
                </ul>
            </div>
        </header>

    )   
}

export default PassosVotacao;