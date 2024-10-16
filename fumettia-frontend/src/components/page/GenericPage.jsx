import React, { useState } from 'react';
import GenericCarousel from '../homepage/GenericCarousel';
import Sidebar from './Sidebar';
import GridView from './GridView';
import { useGetFumettiByRaccomandatoAndTipoQuery, useGetRecommendedFumettiQuery } from '../../api/FumettoApi';
import { useSelector } from 'react-redux';

const GenericPage = ({ type }) => {
    const [view, setView] = useState('carousel');
    const modePage = useSelector((state) => state.theme.mode); // Legge il tema attuale

    // Correggere le chiamate API
    const { data: raccomandati, isLoading: isLoadingRaccomandati } = useGetFumettiByRaccomandatoAndTipoQuery({ tipo: type });
    const { data: consigliati, isLoading: isLoadingConsigliati } = useGetRecommendedFumettiQuery({ tipo: type, utenteId: 1 });

    const handleShowAll = () => {
        setView('grid');
    };

    // Gestione del caricamento
    if (isLoadingRaccomandati || isLoadingConsigliati) {
        return <div>Caricamento...</div>;
    }

    return (
        <div className={modePage === 'dark' ? "dark-homepage-container" :  "light-homepage-container"}>
            <Sidebar />
            <div className={modePage === 'dark' ? "dark-content" : "light-content"}>
                {view === 'carousel' ? (
                    <>
                        {/* 
                        <div className="container mt-4">
                            <GenericCarousel title={`Ultime Uscite ${type}`} data={null} />
                        </div>
                        <div className="container mt-4">
                            <GenericCarousel title={`${type} Più Venduti`} data={null} />
                        </div>
                        */}
                        <div className={modePage === 'dark' ? "dark-container mt-4" : "light-container mt-4"}>
                            <GenericCarousel
                                title={`${type} Raccomandati`}
                                data={raccomandati || []}
                                carouselId={`raccomandati-${type}`}
                            />
                        </div>
                        {/* 
                        <div className="container mt-4">
                            <GenericCarousel title="Novità" data={null} />
                        </div>
                        <div className="container mt-4">
                            <GenericCarousel title="Top del Mese" data={null} />
                        </div>
                        */}
                        <div className={modePage === 'dark' ? "dark-container mt-4" : "light-container mt-4"}>
                            <GenericCarousel
                                title="Consigliati in base a letture precedenti"
                                data={consigliati || []}
                                carouselId={`consigliati-${type}`}
                            />
                        </div>
                    </>
                ) : (
                    <GridView data={null} />
                )}
            </div>
        </div>
    );
};

export default GenericPage;
