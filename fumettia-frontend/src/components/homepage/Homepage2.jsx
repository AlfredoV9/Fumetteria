import React from 'react';
import { useHistory } from 'react-router-dom';
import GenericCarousel from './GenericCarousel';
import { COMICS_AMERICANI, MANGA, MANHWA, WEBTOON, BANDE, COMICS_ITALIANI } from '../../utility/Rotte';
import { useGetUltimiVolumiPerTipoQuery } from '../../api/VolumeApi';
import { useSelector } from 'react-redux';

function Homepage2() {
  const { data: mangaData, error: mangaError } = useGetUltimiVolumiPerTipoQuery('MANGA');
  const { data: manhwaData, error: manhwaError } = useGetUltimiVolumiPerTipoQuery('MANHWA');
  const { data: comixData, error: comixError } = useGetUltimiVolumiPerTipoQuery('COMICS_AMERICANI');
  const { data: webtoonData, error: webtoonError } = useGetUltimiVolumiPerTipoQuery('WEBTOON');
  const { data: bandeDessineeData, error: bandeDessineeError } = useGetUltimiVolumiPerTipoQuery('BANDE_DESSINEE');
  const { data: comicsItalianiData, error: comicsItalianiError } = useGetUltimiVolumiPerTipoQuery('COMICS_ITALIANI');
  const history = useHistory();
  const modePage = useSelector((state) => state.theme.mode);

  const handleMangaClick = () => history.push(MANGA);
  const handleManhwaClick = () => history.push(MANHWA);
  const handleComicsAmeClick = () => history.push(COMICS_AMERICANI);
  const handleComicsItaClick = () => history.push(COMICS_ITALIANI);
  const handleWebtoonClick = () => history.push(WEBTOON);
  const handleBandeClick = () => history.push(BANDE);

  return (
    <div className={modePage === 'dark' ? "dark-homepage-bg" : "light-homepage-bg"}>
      <div className={modePage === 'dark' ? "dark-container mt-4" : "light-container mt-4"}>
        <GenericCarousel
          title="Ultime Uscite Mondo Manga"
          data={mangaData ? mangaData : mangaError}
          carouselId="manga"
        />
        <button type="button" className="btn btn-link text-decoration-underline text-light" onClick={handleMangaClick}>
          Mostra Tutti
        </button>
      </div>

      <div className={modePage === 'dark' ? "dark-container mt-4" : "light-container mt-4"}>
        <GenericCarousel
          title="Ultime Uscite Mondo Manhwa"
          data={manhwaData ? manhwaData : manhwaError}
          carouselId="manhwa"
        />
        <button type="button" className="btn btn-link text-decoration-underline text-light" onClick={handleManhwaClick}>
          Mostra Tutti
        </button>
      </div>

      <div className={modePage === 'dark' ? "dark-container mt-4" : "light-container mt-4"}>
        <GenericCarousel
          title="Ultime Uscite Mondo Comix"
          data={comixData ? comixData : comixError}
          carouselId="comix"
        />
        <button type="button" className="btn btn-link text-decoration-underline text-light" onClick={handleComicsAmeClick}>
          Mostra Tutti
        </button>
      </div>

      <div className={modePage === 'dark' ? "dark-container mt-4" : "light-container mt-4"}>
        <GenericCarousel
          title="Ultime Uscite Mondo Webtoon"
          data={webtoonData ? webtoonData : webtoonError}
          carouselId="webtoon"
        />
        <button type="button" className="btn btn-link text-decoration-underline text-light" onClick={handleWebtoonClick}>
          Mostra Tutti
        </button>
      </div>

      <div className={modePage === 'dark' ? "dark-container mt-4" : "light-container mt-4"}>
        <GenericCarousel
          title="Ultime Uscite Mondo Bande Dessinée"
          data={bandeDessineeData ? bandeDessineeData : bandeDessineeError}
          carouselId="bande"
        />
        <button type="button" className="btn btn-link text-decoration-underline text-light" onClick={handleBandeClick}>
          Mostra Tutti
        </button>
      </div>

      <div className={modePage === 'dark' ? "dark-container mt-4" : "light-container mt-4"}>
        <GenericCarousel
          title="Ultime Uscite Mondo Comics Italiani"
          data={comicsItalianiData ? comicsItalianiData : comicsItalianiError}
          carouselId="comix-ita"
        />
        <button type="button" className="btn btn-link text-decoration-underline text-light" onClick={handleComicsItaClick}>
          Mostra Tutti
        </button>
      </div>
    </div>
  );
}

export default Homepage2;
