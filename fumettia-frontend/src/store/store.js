import { configureStore, combineReducers } from "@reduxjs/toolkit";
import { setupListeners } from "@reduxjs/toolkit/query";
import { persistStore, persistReducer } from "redux-persist";
import storage from "redux-persist/lib/storage";
import volumesReducer from './slice/volumeSlice';
import mangaReducer from './slice/mangaSlice';
import manhwaReducer from './slice/manhwaSlice';
import comixReducer from './slice/comixSlice';
import themeReducer from './slice/themeSlice';
import utenteReducer from './slice/utenteSlice';
import { VolumeApi } from "../api/VolumeApi";
import { FumettoApi } from "../api/FumettoApi";
import { GenereApi } from "../api/GenereApi";
import { UtenteApi } from "../api/UtenteApi";

const persistConfig = {
  key: "root",
  storage,
  whitelist: ['theme'],
};

const rootReducer = combineReducers({
  [VolumeApi.reducerPath]: VolumeApi.reducer,
  [FumettoApi.reducerPath]: FumettoApi.reducer,  
  [GenereApi.reducerPath]: GenereApi.reducer,
  [UtenteApi.reducerPath]: UtenteApi.reducer,
  volumes: volumesReducer,
  manga: mangaReducer,
  manhwa: manhwaReducer,
  comix: comixReducer,
  theme: themeReducer,
  utente: utenteReducer,
});

const persistedReducer = persistReducer(persistConfig, rootReducer);

const store = configureStore({
  reducer: persistedReducer,
  middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware({
      serializableCheck: false,
    }).concat(VolumeApi.middleware, FumettoApi.middleware, GenereApi.middleware, UtenteApi.middleware),
});

setupListeners(store.dispatch);

export const persistor = persistStore(store);

export default store;
