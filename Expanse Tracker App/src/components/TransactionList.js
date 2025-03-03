import React, {useContext, useState} from 'react';
import Transaction, { transaction } from './Transaction';
import { GlobalContext } from '../context/GlobalState';

const TransactionList = () => {
  const { transactions } = useContext(GlobalContext);


  return (
    <>
      <h3>History</h3>
      <ul className="list">
      {transactions.map(transaction => (<Transaction key={transaction.id}
       transaction={transaction} />))}
      </ul>
    </>
  )
}

export default TransactionList
