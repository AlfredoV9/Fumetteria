import React from 'react';
import { useHistory } from 'react-router-dom';
import NavigationButton from './navigation/NavigationButton';
import { COMICS_AMERICANI, MANGA, MANHWA, WEBTOON, BANDE, COMICS_ITALIANI } from '../../utility/Rotte';
import { useSelector } from 'react-redux';

function NavigationBar() {
  const history = useHistory();
  const modePage = useSelector((state) => state.theme.mode);

  const handleMangaClick = () => history.push(MANGA);
  const handleManhwaClick = () => history.push(MANHWA);
  const handleComicsAmeClick = () => history.push(COMICS_AMERICANI);
  const handleComicsItaClick = () => history.push(COMICS_ITALIANI);
  const handleWebtoonClick = () => history.push(WEBTOON);
  const handleBandeClick = () => history.push(BANDE);

  return (
    <nav
      className={modePage === 'dark' ?
        "navbar navbar-expand-lg navbar-dark bg-dark navbar-bottom-border" :
        "navbar navbar-expand-lg navbar-light navbar-bottom-border"}
      style={{
        backgroundColor: modePage === 'light' ? "#e3e3e3" : undefined
      }}>
      <div className="container-fluid justify-content-center">
        <NavigationButton
          onClick={handleMangaClick}
          text="Manga"
        />
        <NavigationButton
          onClick={handleManhwaClick}
          text="Manhwa"
        />
        <NavigationButton
          onClick={handleComicsAmeClick}
          text="Comics Americani"
        />
        <NavigationButton
          onClick={handleComicsItaClick}
          text="Comics Italiani"
        />
        <NavigationButton
          onClick={handleBandeClick}
          text="Bande Dessineè"
        />
        <NavigationButton
          onClick={handleWebtoonClick}
          text="Webtoon"
        />
      </div>
    </nav>
  );
}

export default NavigationBar;
