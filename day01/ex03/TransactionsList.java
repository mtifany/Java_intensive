

import java.util.UUID;

public interface TransactionsList {

void add(Transaction transaction);
void removeTransaction(UUID uuid);
Transaction[] toArray();

}
