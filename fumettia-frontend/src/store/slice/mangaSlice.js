import { createSlice } from '@reduxjs/toolkit';

// Slice per i Manga
const mangaSlice = createSlice({
  name: 'manga',
  initialState: {
    items: [], // Inizialmente vuoto
  },
  reducers: {
    setMangaItems: (state, action) => {
      state.items = action.payload; // Imposta i manga
    },
  },
});

export const { setMangaItems } = mangaSlice.actions;

export const selectMangaItems = (state) => state.manga.items;

export default mangaSlice.reducer;
