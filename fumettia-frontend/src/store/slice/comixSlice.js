import { createSlice } from '@reduxjs/toolkit';

// Slice per i Comix
const comixSlice = createSlice({
  name: 'comix',
  initialState: {
    items: [], // Inizialmente vuoto
  },
  reducers: {
    setComixItems: (state, action) => {
      state.items = action.payload; // Imposta i comix
    },
  },
});

export const { setComixItems } = comixSlice.actions;

export const selectComixItems = (state) => state.comix.items;

export default comixSlice.reducer;
