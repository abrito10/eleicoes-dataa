type Props ={
    amount: number;
    totalVotos: number;
    onSubmit:() => void;
}


function ConfirmarVoto({amount, totalVotos, onSubmit}: Props){
    return (

        <div className = "voto-summary-container">
            <div className = "voto-summary-content">
                <div>
                    <span className="amount-selected-container">
                        <strong className="amount-selected">{amount} </strong>
                        Candidato Selecionados
                    </span>
                    <span className = "voto-summary-total">
                        <strong className="amount-selected">{totalVotos}</strong>
                        Valor Total
                    </span>
                </div> 
                <div>
                <b>{totalVotos>0 ? 
                <button className="voto-summary-make-voto" onClick={onSubmit}> Votar</button>
                : 
                ''}</b>

                </div>
            
            </div>
        </div>

    )
    
}


export default ConfirmarVoto;

