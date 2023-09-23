# Email Client Project

## Overview

This project implements an email client with the ability to manage different types of recipients, send birthday greetings, and save sent emails.

## Assignment Overview

The email client has two types of recipients: official and personal. The details of the recipient list are stored in a text file. The user can update this text file by adding new recipients through the command-line.

When the email client is running, recipient details are loaded from the text file into the application. For each recipient having a birthday, a birthday greeting is sent on the correct day. Different messages are sent to official friends and personal recipients.

All emails sent out by the email client are saved into the hard disk using object serialization. The user can retrieve information about all the mails sent on a particular day using a command-line option.

## Features

- Add a new recipient
- Send an email
- Print names of recipients with birthdays on the current date
- Print details of emails sent on a specified date
- Display the number of recipient objects in the application

## Usage

### Adding a New Recipient

To add a new recipient, use the following command:

```bash
java EmailClient addRecipient <type> <details>
