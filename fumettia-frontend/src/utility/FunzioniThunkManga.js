import { setMangaItems } from '../store/slice/mangaSlice';
import { generateMangaItems } from './FunzioniUtility';

export const initializeMangaItems = () => (dispatch) => {
  const mangaItems = generateMangaItems();
  dispatch(setMangaItems(mangaItems)); // Imposta i manga con un dispatch
};
