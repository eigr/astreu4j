package io.eigr.astreu;

public interface SubscriptionContext extends Context {
    void accept();
    void reject();
}
