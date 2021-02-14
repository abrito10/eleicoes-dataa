import { CargoCandidato } from "./types";

export function checkIsSelected(selectedCargo: CargoCandidato[], cargo: CargoCandidato){
    return selectedCargo.some(item => item.id === cargo.id);
}
