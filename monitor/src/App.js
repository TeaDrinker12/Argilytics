import logo from './logo.svg';
import './App.css';
import useAxios from 'axios-hooks';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <SensorData/>
      </header>
    </div>
  );
}

function SensorData() {
  const [{data, loading, error}, refetch] = useAxios(
    'http://localhost:9001/'
  );
  if (loading) return <p>Loading...</p>;
  if (error) {
    console.log(error);
    return <p>Error!</p>;
  } 
  return (
    <div class="Box">
    <p>
      Hello!!! {data}
    </p>
    </div>
  );
}

export default App;
