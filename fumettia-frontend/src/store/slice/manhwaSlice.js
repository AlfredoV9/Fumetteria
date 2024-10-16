import { createSlice } from '@reduxjs/toolkit';

// Slice per i Manhwa
const manhwaSlice = createSlice({
  name: 'manhwa',
  initialState: {
    items: [], // Inizialmente vuoto
  },
  reducers: {
    setManhwaItems: (state, action) => {
      state.items = action.payload; // Imposta i manhwa
    },
  },
});

export const { setManhwaItems } = manhwaSlice.actions;

export const selectManhwaItems = (state) => state.manhwa.items;

export default manhwaSlice.reducer;
