import './App.css';
import useAxios from 'axios-hooks';
import { useState, useEffect } from 'react';

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
  const [{data, loading, error}, refetch] = useAxios('http://localhost:9001/reading');
  const [intervalState, setIntervalState] = useState(false);
  const gatewayDisconnected = data && new Date(data.timestamp).getTime() + 15 * 1000 < new Date().getTime();
  useEffect(() => {
    console.log('will check interval')
    if (!intervalState) {
      setIntervalState(true);
      console.log('interval will be set');
      setInterval(function() {
        refetch();
      }, 5000);
    }
  }, [intervalState, refetch]);
  if (loading && !data) {
    return <p>Loading...</p>;
  }
  if (error) {
    console.log(error);
    return <p>Error!</p>;
  }
  if (gatewayDisconnected) {
    return <p>Gateway Disconnected</p>
  }
  return (
    <div className="Box">
    <p>
      Temprature: {data.temprature}<sup>°C</sup>
    </p>
    </div>
  );
}

export default App;
