import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import { HOMEPAGE, COMICS_AMERICANI, MANGA, MANHWA, WEBTOON, BANDE, COMICS_ITALIANI } from "./Rotte";
import GenericPage from "../components/page/GenericPage";
import UserNavbar from "../components/navbar/UserNavbar";
import NavigationBar from "../components/navbar/NavigationNavbar";
import ScrollToTop from "./ScrollToTop";
import Homepage2 from "../components/homepage/Homepage2";
import "../styles/SiteDarkModeStyle.css";
import "../styles/SiteLightModeStyle.css";
import "../styles/GeneralSiteStyle.css";

function Routering() {
  return (
    <Router>
      <ScrollToTop />

      <div className="layout-container">
        <div className="navbar-container">
          <UserNavbar />
          <NavigationBar />
        </div>

        <div className="content-container">
          <Switch>
            <Route exact path={HOMEPAGE} component={Homepage2} />
            <Route exact path={MANGA} render={() => <GenericPage type="MANGA" />} />
            <Route exact path={MANHWA} render={() => <GenericPage type="MANHWA" />} />
            <Route exact path={COMICS_AMERICANI} render={() => <GenericPage type="COMICS_AMERICANI" />} />
            <Route exact path={COMICS_ITALIANI} render={() => <GenericPage type="COMICS_ITALIANI" />} />
            <Route exact path={BANDE} render={() => <GenericPage type="BANDE_DESSINEE" />} />
            <Route exact path={WEBTOON} render={() => <GenericPage type="WEBTOON" />} />
          </Switch>
        </div>
      </div>
    </Router>
  );
}

export default Routering;
