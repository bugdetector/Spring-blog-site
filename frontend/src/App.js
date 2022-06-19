import { BrowserRouter, Routes, Route } from "react-router-dom";

import Layout from "./pages/Layout";
import Home from "./pages/Home";
import Page from "./pages/Page";
import Products from "./pages/Products";
import Testimonials from "./pages/Testimonials";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Home />} />
          <Route path="/products" element={<Products />} />
          <Route path="/testimonial" element={<Testimonials />} />
          <Route path="/:url_alias" element={<Page />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
