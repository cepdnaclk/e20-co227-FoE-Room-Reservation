import { ReactNode, useState } from 'react';
import GlobalContext from './GlobalContext';
import dayjs from 'dayjs';

interface ContextWrapperProps {
  children: ReactNode;
}

const ContextWrapper = ({ children }: ContextWrapperProps) => {
  const [monthIndex, setMonthIndex] = useState(dayjs().month());
  const [dayIndex, setDayIndex] = useState(dayjs().date());

  return (
    <GlobalContext.Provider value={{ monthIndex, setMonthIndex, dayIndex, setDayIndex }}>
      {children}
    </GlobalContext.Provider>
  );
};

export default ContextWrapper;
