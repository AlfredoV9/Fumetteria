import { setManhwaItems } from '../store/slice/manhwaSlice';
import { generateManhwaItems } from './FunzioniUtility';

export const initializeManhwaItems = () => (dispatch) => {
    const manhwaItems = generateManhwaItems();
    dispatch(setManhwaItems(manhwaItems));
  };