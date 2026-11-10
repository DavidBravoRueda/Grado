def send_messages(messages, sent_messages):
    while messages:
        current_message = messages.pop()
        print(f"message: {current_message}")
        sent_messages.append(current_message)

messages_list = ["email John", "buy flowers", "complete tutorial", "buy food"]

sent_messages_list = []

send_messages(messages_list, sent_messages_list)

print("\nMessages sent  --------------------------------------------")
print(messages_list)
print(sent_messages_list)
