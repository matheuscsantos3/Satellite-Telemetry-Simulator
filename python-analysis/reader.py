import re

temperatures = []
radiations = []

with open("../java-simulator/telemetry.csv", "r") as file:

    for line in file:

        temp_match = re.search(r"temperature=([\d.]+)", line)
        rad_match = re.search(r"radiation=([\d.]+)", line)

        if temp_match and rad_match:

            temperatures.append(float(temp_match.group(1)))
            radiations.append(float(rad_match.group(1)))

print("Packets:", len(temperatures))

print("Average temperature:", sum(temperatures) / len(temperatures))
print("Average radiation:", sum(radiations) / len(radiations))