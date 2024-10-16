import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  collection: [],
};

const volumesSlice = createSlice({
  name: 'volumes',
  initialState,
  reducers: {
    addVolumesToCollection: (state, action) => {
      // Aggiunge i volumi selezionati alla collezione
      state.collection = [...state.collection, ...action.payload];
    },
    removeVolumeFromCollection: (state, action) => {
      // Rimuove un volume specifico dalla collezione
      state.collection = state.collection.filter(
        (volume) => !(volume.title === action.payload.title && volume.number === action.payload.number)
      );
    },
    clearCollection: (state) => {
      // Pulisce completamente la collezione
      state.collection = [];
    },
  },
});

// Esporta le azioni generate automaticamente
export const { addVolumesToCollection, removeVolumeFromCollection, clearCollection } = volumesSlice.actions;

// Esporta il reducer per includerlo nello store
export default volumesSlice.reducer;
