import sys
import os
print(sys.argv)

if len(sys.argv) == 1:
    print("No Arguments passed")
    sys.exit()

agent = sys.argv[1]
path = "~/DEV/android/kotlin-mp-test/src/commonMain/kotlin/api/"
print(agent)
print(path)

agent = agent.lower()
print(agent)

os.mkdir(path + agent + "/")