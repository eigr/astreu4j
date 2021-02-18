package io.eigr.astreu;

public interface SubscriptionContext extends Context {
    void accept();
    void accept(String reason);
    void reject();
    void reject(String reason);
}
