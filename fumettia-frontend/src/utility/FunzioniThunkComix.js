import { setComixItems } from '../store/slice/comixSlice';
import { generateComixItems } from './FunzioniUtility';

export const initializeComixItems = () => (dispatch) => {
  const comixItems = generateComixItems();
  dispatch(setComixItems(comixItems));
};
